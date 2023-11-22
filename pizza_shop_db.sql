-- LEER IMPORTANTE!!!
-- Primero se debe crear la base de datos pizza_shop en postgres
-- Luego ejecutar el script conectado desde la bd que acabas de crear

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";;

-- tables
-- Table: banner
CREATE TABLE banner (
    id serial  NOT NULL,
    image_url varchar(200)  NOT NULL,
    title varchar(100)  NOT NULL,
    slug varchar(100)  NOT NULL,
    grouped boolean  NOT NULL,
    data json  NOT NULL,
    start_date timestamp  NULL,
    end_date timestamp  NULL,
    acrtive boolean  NOT NULL,
    CONSTRAINT banner_pk PRIMARY KEY (id)
);

-- Table: category
CREATE TABLE category (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    description varchar(100)  NULL,
    slug varchar(100)  NOT NULL,
    shortcut boolean  NULL,
    active boolean  NOT NULL,
    CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order" (
    id serial  NOT NULL,
    person_id int  NOT NULL,
    address varchar(100)  NOT NULL,
    sale_date timestamp  NOT NULL,
    amount_total decimal(10,5)  NOT NULL,
    order_type varchar(20)  NOT NULL,
    payment_method varchar(30)  NOT NULL,
    payment_date timestamp  NOT NULL,
    latitude decimal  NULL,
    longitude decimal  NULL,
    state varchar(20)  NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: order_line
CREATE TABLE order_line (
    id serial  NOT NULL,
    order_id int  NOT NULL,
    product_id int  NOT NULL,
    quantity int  NOT NULL,
    price_unit decimal(10,5)  NOT NULL,
    price_total decimal(10,5)  NOT NULL,
    CONSTRAINT order_line_pk PRIMARY KEY (id)
);

-- Table: person
CREATE TABLE person (
    id serial  NOT NULL,
    uuid uuid  NOT NULL,
    name varchar(50)  NOT NULL,
    lastname varchar(50)  NOT NULL,
    birthdate date  NOT NULL,
    phone varchar(10)  NULL,
    email varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    verified boolean  NOT NULL,
    active boolean  NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id)
);

-- Table: person_address
CREATE TABLE person_address (
    id serial  NOT NULL,
    person_id int  NOT NULL,
    address varchar(100)  NOT NULL,
    latitude decimal  NOT NULL,
    longitude decimal  NOT NULL,
    CONSTRAINT person_address_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    description varchar(200)  NULL,
    image_url varchar(200)  NOT NULL,
    rating int  NULL,
    category_id int  NOT NULL,
    slug varchar(100)  NOT NULL,
    price decimal(10,5)  NOT NULL,
    active boolean  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table: shopping_cart
CREATE TABLE shopping_cart (
    id serial  NOT NULL,
    person_id int  NOT NULL,
    product_id int  NOT NULL,
    quantity int  NOT NULL,
    CONSTRAINT shopping_cart_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: order_line_order (table: order_line)
ALTER TABLE order_line ADD CONSTRAINT order_line_order
    FOREIGN KEY (order_id)
    REFERENCES "order" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_line_product (table: order_line)
ALTER TABLE order_line ADD CONSTRAINT order_line_product
    FOREIGN KEY (product_id)
    REFERENCES product (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: order_person (table: order)
ALTER TABLE "order" ADD CONSTRAINT order_person
    FOREIGN KEY (person_id)
    REFERENCES person (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: person_address_person (table: person_address)
ALTER TABLE person_address ADD CONSTRAINT person_address_person
    FOREIGN KEY (person_id)
    REFERENCES person (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: product_category (table: product)
ALTER TABLE product ADD CONSTRAINT product_category
    FOREIGN KEY (category_id)
    REFERENCES category (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: shopping_cart_person (table: shopping_cart)
ALTER TABLE shopping_cart ADD CONSTRAINT shopping_cart_person
    FOREIGN KEY (person_id)
    REFERENCES person (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: shopping_cart_product (table: shopping_cart)
ALTER TABLE shopping_cart ADD CONSTRAINT shopping_cart_product
    FOREIGN KEY (product_id)
    REFERENCES product (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

INSERT INTO public.banner (image_url, title, slug, grouped, data, start_date, end_date, active) VALUES ('', 'Banner 00001', 'banner-00001', false, '{"products": [{"id": 1}, {"id": 2}]}', '2023-11-13 06:49:34.292000', '2023-11-13 06:49:34.292000', true);

INSERT INTO public.person (name, lastname, birthdate, phone, email, password, verified, active, uuid) VALUES ('Alvaro Felipe', 'Iturrizaga Vargas', '1999-03-18', '988852365', 'alvaro.iturrizaga@gmail.com', '000111333', false, true, 'dffdc19c-93a0-4d30-9273-a4cc6bc97ba2');

INSERT INTO public.category (name, description, slug, shortcut, active) VALUES ('Pizzas', 'Pizzas de todos los sabores', 'pizzas', true, true);
INSERT INTO public.category (name, description, slug, shortcut, active) VALUES ('Complementos', 'Complementos para las pizzas', 'complementos', true, true);
INSERT INTO public.category (name, description, slug, shortcut, active) VALUES ('Anti pastas', 'Platos de entrada', 'anti-pastas', false, false);
INSERT INTO public.category (name, description, slug, shortcut, active) VALUES ('Bebidas Heladas', 'Bebidas frescas', 'bebidas-heladas', false, true);

INSERT INTO public.product (name, description, image_url, rating, category_id, slug, price, active) VALUES ('Pizza Americana Clasica', 'Pizza americana clasica con tomate, queso y jamon', '', 4, 1, 'pizza-americana-clasica', 30.00000, true);


