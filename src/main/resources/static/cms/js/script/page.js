var basePage = {
    countryImgSrc: ["https://wpimg.wallstcn.com/32/75/86/usa-2x.png",
        "https://wpimg.wallstcn.com/4b/8f/f7/eurozone-2x.png",
        "https://wpimg.wallstcn.com/0d/ce/36/england.png",
        "https://wpimg.wallstcn.com/84/39/2c/japan-2x.png",
        "https://wpimg.wallstcn.com/81/fe/c2/australian-2x.png",
        "https://wpimg.wallstcn.com/f8/f5/ee/zealand-2x.png",
        "https://wpimg.wallstcn.com/2e/ef/c6/swit-2x.png",
        "https://wpimg.wallstcn.com/96/ef/7b/candar-2x.png",
        "https://wpimg.wallstcn.com/de/bf/b5/china-2x.png",
        "https://wpimg.wallstcn.com/32/75/86/usa-2x.png"],
    countryImgSrcObj: {
        FederalReserve: "https://wpimg.wallstcn.com/32/75/86/usa-2x.png",
        Euro: "https://wpimg.wallstcn.com/4b/8f/f7/eurozone-2x.png",
        UK: "https://wpimg.wallstcn.com/0d/ce/36/england.png",
        Japan:"https://wpimg.wallstcn.com/84/39/2c/japan-2x.png",
        Australia:"https://wpimg.wallstcn.com/81/fe/c2/australian-2x.png",
        NewZealand:"https://wpimg.wallstcn.com/f8/f5/ee/zealand-2x.png",
        Switzerland:"https://wpimg.wallstcn.com/2e/ef/c6/swit-2x.png",
        Canada:"https://wpimg.wallstcn.com/96/ef/7b/candar-2x.png",
        China:"https://wpimg.wallstcn.com/de/bf/b5/china-2x.png",
        USA:"https://wpimg.wallstcn.com/32/75/86/usa-2x.png"
    },
    getCountryImg: (code) => {
        try {
            if(basePage.countryImgSrc[code]){
                return  basePage.countryImgSrc[code]
            }
            throw e;
        } catch (e) {
            try {
                if(basePage.countryImgSrcObj[code]){
                    return  basePage.countryImgSrcObj[code]
                }
                throw e;
            } catch (e) {
                return "/cms/img/default.png"
            }
        }
    }
}