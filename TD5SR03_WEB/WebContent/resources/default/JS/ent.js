var heure;



function setOngletEdit(index)
{
	$("data")[0].reset();
}
//----Arbre dépliant---


//---------------------

$(function() {
	$('nav#menu').mmenu();
});


function reload()
{
	location.reload();
}

$('menu').click(function() {
    if($('#left').hasClass('mm-opened')) {
        $("#nav").trigger("close.mm")
    }
});

$(document).ready(function(){

	$("#one a").click(function(e){

		e.preventDefault();
		$("#one li.active").removeClass("active");
		$("#two li.active").removeClass("active");
	});

	$("#two a").click(function(e){

		e.preventDefault();
		$("#one li.active").removeClass("active");
		$("#two li.active").removeClass("active");
	});

});  

function affApp(type)
{
	switch(type)
	{
		case 0: $("#LesApplications").attr('class','');break;
		case 1: $("#LesApplications").attr('class','DisplayList');break;
		default: $("#LesApplications").attr('class','');
	}
}


function disconnect()
{
	document.location.href="Logout";
}


function closeall()
{
	$("#LeTrombi").collapse('hide');
	if($('#menu').hasClass('mm-opened')) {
		$('#menu').removeClass('mm-current mm-opened');
		$('html').removeClass('mm-background mm-opening');
    }
}


function checktime(){

	var now = new Date();

	var hour = now.getHours();
	if(hour < 10) hour = "0" + hour;

	var mins = now.getMinutes();
	if(mins < 10) mins = "0" + mins;


	heure = hour+":"+mins;
	$('#Hour').text(heure);
	setTimeout(function(){checktime();}, 1000); 
};

checktime();
