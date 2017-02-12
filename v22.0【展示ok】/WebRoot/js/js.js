$(document).ready(function(){
	/*下拉菜单效果   主要是解决滚动字体覆盖菜单栏问题*/
	 $('#yt_menu_li').hover(function(){
		 $('#yt_menu_li').removeClass().addClass("menu1");
         $("marquee").css('display','none');
         alert($("#yt_broadcast").Text());
        },function(){
        	 $('#yt_menu_li').removeClass().addClass("menu2");
        	 $("marquee").css('display','');
           });
});