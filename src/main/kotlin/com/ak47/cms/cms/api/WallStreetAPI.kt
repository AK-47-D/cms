package com.ak47.cms.cms.api

object WallStreetAPI {
    val STOCK_INDEX_API = "http://forexdata.wallstreetcn.com/real?en_prod_code=XAUUSD,XAGUSD,UKOIL,US10YEAR,JAPAN10YEAR,GERMANY10YEAR,EURUSD,USDCNH,USDJPY,SPX500INDEX,JPN225INDEX,EUSTX50INDEX,000001,399001,399006&fields=prod_name,last_px,px_change,px_change_rate,price_precision"

    val 实时快讯_API = "https://api-prod.wallstreetcn.com/apiv1/finfo/calendars?start=1509715475&end=1510320275&limit=10&importances=3&stars=3"

    val China_财经新闻_API = "https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=china&limit=10"

    val US_财经新闻_API = "https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=us&limit=10"

    val Europe_财经新闻_API = "https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=europe&limit=10"
}