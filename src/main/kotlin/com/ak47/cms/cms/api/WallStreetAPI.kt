package com.ak47.cms.cms.api

object WallStreetAPI {
    val STOCK_INDEX_API = "http://forexdata.wallstreetcn.com/real?en_prod_code=XAUUSD,XAGUSD,UKOIL,US10YEAR,JAPAN10YEAR,GERMANY10YEAR,EURUSD,USDCNH,USDJPY,SPX500INDEX,JPN225INDEX,EUSTX50INDEX,000001,399001,399006&fields=prod_name,last_px,px_change,px_change_rate,price_precision"

    val China_财经新闻_API = "https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=china"

    val US_财经新闻_API = "https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=us"

    val Europe_财经新闻_API = "https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=europe"

    // val 实时快讯_API = "https://api-prod.wallstreetcn.com/apiv1/finfo/calendars?start=1509715475&end=1510320275&importances=3&stars=3"
    val 财经日历_API = "https://api-prod.wallstreetcn.com/apiv1/finfo/calendars?start=1509897600&end=1509983999"

    val 央行利率_API = "https://api-prod.wallstreetcn.com/apiv1/finfo/cbrates"

}


/*
全球资讯

全球   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=global&platform=wscn-platform
股市   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=shares&platform=wscn-platform
债市   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=bonds&platform=wscn-platform
商品   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=commodities&platform=wscn-platform
外汇   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=forex&platform=wscn-platform
公司   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=enterprise&platform=wscn-platform
经济   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=economy&platform=wscn-platform
数据   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=charts&platform=wscn-platform
中国   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=china&platform=wscn-platform
US    https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=us
欧洲   https://api-prod.wallstreetcn.com/apiv1/content/articles?platform=wscn-platform&category=europe
日本   https://api-prod.wallstreetcn.com/apiv1/content/articles?category=japan&platform=wscn-platform
*/