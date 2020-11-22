CREATE TABLE public.formas_pago
(
    id serial NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(100),
    CONSTRAINT pk_id_formas_pago PRIMARY KEY (id)
);