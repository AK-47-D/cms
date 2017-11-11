CREATE SCHEMA `ak47_cms` DEFAULT CHARACTER SET utf8 ;

SHOW TABLES;

DESC stock_index;

DESC news_artical;

SELECT *
FROM news_artical;

SELECT *
FROM stock_index;

SELECT count(*)
FROM news_artical;

select count(*) from news_artical;
SELECT *
FROM finance_info_calendar;

DELETE from finance_info_calendar;


SELECT count(*)
FROM wallstreet_article;



SELECT *
FROM wallstreet_article;

SELECT *
FROM center_bank_rate;


DELETE from focus_live_news;

SELECT count(*) from image WHERE source_type = 2;