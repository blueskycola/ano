PGDMP         7                {            ano    15.2    15.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16466    ano    DATABASE     v   CREATE DATABASE ano WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Japanese_Japan.932';
    DROP DATABASE ano;
                postgres    false            �            1259    16467    usr    TABLE     ~   CREATE TABLE public.usr (
    uno numeric(20,0) NOT NULL,
    uname character varying(10),
    age numeric,
    bdate date
);
    DROP TABLE public.usr;
       public         heap    postgres    false            �          0    16467    usr 
   TABLE DATA           5   COPY public.usr (uno, uname, age, bdate) FROM stdin;
    public          postgres    false    214          e           2606    16475    usr pk_user 
   CONSTRAINT     J   ALTER TABLE ONLY public.usr
    ADD CONSTRAINT pk_user PRIMARY KEY (uno);
 5   ALTER TABLE ONLY public.usr DROP CONSTRAINT pk_user;
       public            postgres    false    214            �   f   x�3�|>eÓk_tm|�v������������!����!gIjq	�2�K��$� FƸt���a�K�.�tX��a�C��.�1~��`�+F��� }�BU     