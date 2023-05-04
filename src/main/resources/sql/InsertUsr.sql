-- ユーザーテーブルに新規レコードをINSERT
insert
into USR (
    UNO
,   UNAME
,   AGE
,   BDATE
) values (
    /*UNO*/1000     -- UNO      NUMBER(4) NOT NULL
,   'test02'        -- ENAME    VARCHAR2(10)
,   0               -- AGE      NUMBER(7,2)
,   CURRENT_DATE    -- BDATE    DATE
)
