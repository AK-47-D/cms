$('.countdown').downCount({
    date: '11/27/2017 00:00:00',
    offset: +8
}, function () {
    alert('倒计时结束!');
});