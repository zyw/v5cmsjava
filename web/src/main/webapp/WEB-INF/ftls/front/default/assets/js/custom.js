$(document).ready(function() { 
	//语言选择
	$('.language-select ul.sf-menu').superfish({ 
		delay:       500,
		animation:   {opacity:'fast',height:'show'},
		speed:       'fast',
		autoArrows:  true,
		dropShadows: false 
	});
	
	// 菜单
	$('.nav-area ul.sf-menu').superfish({ 
		delay:       500,
		//animation:   {opacity:'fast',height:'show'},
		speed:       'fast',
		autoArrows:  true,
		dropShadows: false 
	}); 
	
	//tab		
	$(".tabs-nav").tabs(" > .tabs-panes > div");
	
	// accordion
	$(".accordion").tabs(".accordion .accordion-pane", {tabs: '.accordion-handle', effect: 'slide',initialIndex: 0});
	$.tools.tabs.addEffect("slide", function(tabIndex, done) {
		this.getPanes().slideUp("fast").eq(tabIndex).slideDown("fast");
		done.call();
	});
		
	
		
	//table
	/*
	$(".table tbody>tr:odd").addClass("odd-row");
	$(".table tbody>tr:even").addClass("even-row");
	$(".table tbody>tr").hover(function(){ 
		$(this).addClass("trhover");
	},function(){
		$(this).removeClass("trhover");
	});*/

	
}); 