$(document).ready(function(){
	/*�����˵�Ч��   ��Ҫ�ǽ���������帲�ǲ˵�������*/
	 $('#yt_menu_li').hover(function(){
		 $('#yt_menu_li').removeClass().addClass("menu1");
         $("marquee").css('display','none');
         alert($("#yt_broadcast").Text());
        },function(){
        	 $('#yt_menu_li').removeClass().addClass("menu2");
        	 $("marquee").css('display','');
           });
});