--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: classifications; Type: TABLE; Schema: public; Owner: ryanjones
--

CREATE TABLE classifications (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE classifications OWNER TO ryanjones;

--
-- Name: strains; Type: TABLE; Schema: public; Owner: ryanjones
--

CREATE TABLE strains (
    id integer NOT NULL,
    name character varying,
    id_classifications integer
);


ALTER TABLE strains OWNER TO ryanjones;

--
-- Name: flavors_id_seq; Type: SEQUENCE; Schema: public; Owner: ryanjones
--

CREATE SEQUENCE flavors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE flavors_id_seq OWNER TO ryanjones;

--
-- Name: flavors_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ryanjones
--

ALTER SEQUENCE flavors_id_seq OWNED BY strains.id;


--
-- Name: stoners; Type: TABLE; Schema: public; Owner: ryanjones
--

CREATE TABLE stoners (
    id integer NOT NULL,
    name character varying,
    favorite_strain character varying
);


ALTER TABLE stoners OWNER TO ryanjones;

--
-- Name: stoners_id_seq; Type: SEQUENCE; Schema: public; Owner: ryanjones
--

CREATE SEQUENCE stoners_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stoners_id_seq OWNER TO ryanjones;

--
-- Name: stoners_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ryanjones
--

ALTER SEQUENCE stoners_id_seq OWNED BY stoners.id;


--
-- Name: strains_id_seq; Type: SEQUENCE; Schema: public; Owner: ryanjones
--

CREATE SEQUENCE strains_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE strains_id_seq OWNER TO ryanjones;

--
-- Name: strains_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: ryanjones
--

ALTER SEQUENCE strains_id_seq OWNED BY classifications.id;


--
-- Name: classifications id; Type: DEFAULT; Schema: public; Owner: ryanjones
--

ALTER TABLE ONLY classifications ALTER COLUMN id SET DEFAULT nextval('strains_id_seq'::regclass);


--
-- Name: stoners id; Type: DEFAULT; Schema: public; Owner: ryanjones
--

ALTER TABLE ONLY stoners ALTER COLUMN id SET DEFAULT nextval('stoners_id_seq'::regclass);


--
-- Name: strains id; Type: DEFAULT; Schema: public; Owner: ryanjones
--

ALTER TABLE ONLY strains ALTER COLUMN id SET DEFAULT nextval('flavors_id_seq'::regclass);


--
-- Data for Name: classifications; Type: TABLE DATA; Schema: public; Owner: ryanjones
--

COPY classifications (id, name) FROM stdin;
\.


--
-- Name: flavors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ryanjones
--

SELECT pg_catalog.setval('flavors_id_seq', 1, false);


--
-- Data for Name: stoners; Type: TABLE DATA; Schema: public; Owner: ryanjones
--

COPY stoners (id, name, favorite_strain) FROM stdin;
1	Creed	Sativa
2	Tyler	Boss OG
3	Jessica	Purple Hindu Kush
4	Creed	OG Kush
5	Tyler	Boss OG
6	Jessica	Purple Hindu Kush
7	Creed	OG Kush
8	Tyler	Boss OG
9	Jessica	Purple Hindu Kush
10	Creed	OG Kush
\.


--
-- Name: stoners_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ryanjones
--

SELECT pg_catalog.setval('stoners_id_seq', 10, true);


--
-- Data for Name: strains; Type: TABLE DATA; Schema: public; Owner: ryanjones
--

COPY strains (id, name, id_classifications) FROM stdin;
\.


--
-- Name: strains_id_seq; Type: SEQUENCE SET; Schema: public; Owner: ryanjones
--

SELECT pg_catalog.setval('strains_id_seq', 1, false);


--
-- Name: strains flavors_pkey; Type: CONSTRAINT; Schema: public; Owner: ryanjones
--

ALTER TABLE ONLY strains
    ADD CONSTRAINT flavors_pkey PRIMARY KEY (id);


--
-- Name: stoners stoners_pkey; Type: CONSTRAINT; Schema: public; Owner: ryanjones
--

ALTER TABLE ONLY stoners
    ADD CONSTRAINT stoners_pkey PRIMARY KEY (id);


--
-- Name: classifications strains_pkey; Type: CONSTRAINT; Schema: public; Owner: ryanjones
--

ALTER TABLE ONLY classifications
    ADD CONSTRAINT strains_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

