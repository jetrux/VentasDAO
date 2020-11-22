CREATE TABLE public.facturas
(
    id serial NOT NULL,
    producto_id integer NOT NULL,
    cantidad_producto integer NOT NULL,
    cliente_id integer NOT NULL,
    formas_pago_id integer NOT NULL,
    numero_factura serial NOT NULL,
	fecha date NOT NULL,
    observacion character varying(150),
    CONSTRAINT pk_id_facturas PRIMARY KEY (id),
    CONSTRAINT fk_producto_id FOREIGN KEY (producto_id)
        REFERENCES public.productos (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_cliente_id FOREIGN KEY (cliente_id)
        REFERENCES public.clientes (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
	CONSTRAINT fk_formas_pago_id FOREIGN KEY (formas_pago_id)
        REFERENCES public.formas_pago (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);