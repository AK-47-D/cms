var mainjs = {
    createPNotify:function(title,text,type,delay){
        new PNotify({
            title: title,
            styling : 'bootstrap3',
            text: text,
            type: type,
            delay:delay
        });
    },
    createDefaultPNotify:function(title,text,type){
        this.createPNotify(title,text,type,5000);
    }
}