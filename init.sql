CREATE SCHEMA wallet;

CREATE SEQUENCE wallet.account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE wallet.account (
    id bigint DEFAULT nextval('wallet.account_id_seq'::regclass) NOT NULL,
    player_id bigint NOT NULL,
    created_date date NOT NULL,
    balance bigint
);

CREATE SEQUENCE wallet.player_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE wallet.player (
    id bigint DEFAULT nextval('wallet.player_id_seq'::regclass) NOT NULL,
    name character varying NOT NULL,
    sex character(1) NOT NULL,
    created_date date NOT NULL
);

CREATE SEQUENCE wallet.transaction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE wallet.transaction (
    id bigint DEFAULT nextval('wallet.transaction_id_seq'::regclass) NOT NULL,
    account_transaction_id bigint NOT NULL,
    player_id bigint NOT NULL,
    account_id bigint NOT NULL,
    type character(1) NOT NULL,
    status character varying NOT NULL,
    reference character varying NOT NULL,
    created_date date NOT NULL,
    amount bigint
);


INSERT INTO wallet.account (id, player_id, created_date, balance) VALUES (1, 1, '2020-03-16', 0);


INSERT INTO wallet.player (id, name, sex, created_date) VALUES (1, 'Amit', 'M', '2020-03-16');

INSERT INTO wallet.transaction (id, account_transaction_id, player_id, account_id, type, status, reference, created_date, amount) VALUES (2, 1, 1, 1, 'C', 'SUCCESS', 'Credit', '2020-03-16', 20);
INSERT INTO wallet.transaction (id, account_transaction_id, player_id, account_id, type, status, reference, created_date, amount) VALUES (1, 1, 1, 1, 'D', 'SUCCESS', 'Debit', '2020-03-16', 100);
INSERT INTO wallet.transaction (id, account_transaction_id, player_id, account_id, type, status, reference, created_date, amount) VALUES (3, 1, 1, 1, 'C', 'SUCCESS', 'Credit', '2020-03-16', 100);
INSERT INTO wallet.transaction (id, account_transaction_id, player_id, account_id, type, status, reference, created_date, amount) VALUES (4, 1, 1, 1, 'C', 'SUCCESS', 'Credit', '2020-03-16', 100);
INSERT INTO wallet.transaction (id, account_transaction_id, player_id, account_id, type, status, reference, created_date, amount) VALUES (5, 1, 1, 1, 'D', 'SUCCESS', 'Debit', '2020-03-16', 120);


SELECT pg_catalog.setval('wallet.account_id_seq', 1, true);


--
-- TOC entry 4003 (class 0 OID 0)
-- Dependencies: 324
-- Name: player_id_seq; Type: SEQUENCE SET; Schema: wallet; Owner: postgres
--

SELECT pg_catalog.setval('wallet.player_id_seq', 1, true);


--
-- TOC entry 4004 (class 0 OID 0)
-- Dependencies: 326
-- Name: transaction_id_seq; Type: SEQUENCE SET; Schema: wallet; Owner: postgres
--

SELECT pg_catalog.setval('wallet.transaction_id_seq', 5, true);


--
-- TOC entry 3859 (class 2606 OID 35302)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: wallet; Owner: postgres
--

ALTER TABLE ONLY wallet.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 3862 (class 2606 OID 35304)
-- Name: player player_pkey; Type: CONSTRAINT; Schema: wallet; Owner: postgres
--

ALTER TABLE ONLY wallet.player
    ADD CONSTRAINT player_pkey PRIMARY KEY (id);


--
-- TOC entry 3866 (class 2606 OID 35306)
-- Name: transaction transaction_pkey; Type: CONSTRAINT; Schema: wallet; Owner: postgres
--

ALTER TABLE ONLY wallet.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (id);


--
-- TOC entry 3860 (class 1259 OID 35307)
-- Name: fki_fk_account_player; Type: INDEX; Schema: wallet; Owner: postgres
--

CREATE INDEX fki_fk_account_player ON wallet.account USING btree (player_id);


--
-- TOC entry 3863 (class 1259 OID 35308)
-- Name: fki_fk_transaction_account; Type: INDEX; Schema: wallet; Owner: postgres
--

CREATE INDEX fki_fk_transaction_account ON wallet.transaction USING btree (account_id);


--
-- TOC entry 3864 (class 1259 OID 35309)
-- Name: fki_fk_transaction_player; Type: INDEX; Schema: wallet; Owner: postgres
--

CREATE INDEX fki_fk_transaction_player ON wallet.transaction USING btree (player_id);


--
-- TOC entry 3867 (class 2606 OID 35310)
-- Name: account fk_account_player; Type: FK CONSTRAINT; Schema: wallet; Owner: postgres
--

ALTER TABLE ONLY wallet.account
    ADD CONSTRAINT fk_account_player FOREIGN KEY (player_id) REFERENCES wallet.player(id) NOT VALID;


--
-- TOC entry 3868 (class 2606 OID 35315)
-- Name: transaction fk_transaction_account; Type: FK CONSTRAINT; Schema: wallet; Owner: postgres
--

ALTER TABLE ONLY wallet.transaction
    ADD CONSTRAINT fk_transaction_account FOREIGN KEY (account_id) REFERENCES wallet.account(id) NOT VALID;


--
-- TOC entry 3869 (class 2606 OID 35320)
-- Name: transaction fk_transaction_player; Type: FK CONSTRAINT; Schema: wallet; Owner: postgres
--

ALTER TABLE ONLY wallet.transaction
    ADD CONSTRAINT fk_transaction_player FOREIGN KEY (player_id) REFERENCES wallet.player(id) NOT VALID;


-- Completed on 2020-03-16 17:50:35

--
-- PostgreSQL database dump complete
--

