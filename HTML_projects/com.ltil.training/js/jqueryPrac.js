$(document).ready(function(){

    $("#btn1").click(function(){
       $("p").toggle();
    });

    $("#p1").click(function(){
        $(this).toggle();
    });

    $("#btn2").click(function(){
        $("ul li:first-child").toggle();
    });

    $("#p5").mouseenter(function(){
        $(this).css("color","pink");
    });

    $("#p5").mouseleave(function(){
        $(this).css("color","orange");
    });

    $("#p4").on(
        {
            mouseenter:function(){
                $(this).css("font-size","25px");
            },
            mouseleave:function(){
                $(this).css("font-size","16px");
            },
            click:function(){
                $(this).css("color","green");
            }
        }
    )

    $("#p3").click(function(){
        alert("value of p3 : "+$('#p3').text());
    });

    $("#btn3").click(function(){
        $("#div1").fadeTo(3000,0.5,function(){alert("Hi I am Div 1..")});
        $("#div2").fadeIn(4000);
        $("#div3").fadeIn(5000);
    });

    $("#btn4").click(function(){
        $("#div4").fadeOut(3000);
        $("#div5").fadeOut(4000);
        $("#div6").fadeOut(5000);
    });

    $("#btn4").click(function(){
        $("#div4").fadeToggle();
        $("#div5").fadeToggle();
        $("#div6").fadeToggle();
    });

    /*$("#btn4").click(function(){
       $("#img1").fadeToggle();
    });*/

    $("#btnmarq").click(function(){
        $("#marq").slideToggle(1000);
        
    });

    $("#anima").click(function(){
       $("#animadiv").animate({
            left:'400px',
            opacity:'0.6',
            height:'200px',
            width:'300px'
       });
    });

    $("#p2").click(function(){
        $("#p3").remove();
        $("#p1").empty();        
    });

    $("#addClass").click(function(){
        $("#paraTony").addClass('green');
    });

    $("#btnAjax").click(function(){
        //$("#ajaxDiv").load('data.txt');      
        $.get('data.txt',function(data,status){
            $("#ajaxDiv").text(data);
            alert(data + " " + status);
        });
    });

});

function addText(){
    var tag1 = "<strong>LTI</strong>";
    var tag2 = $("<em></em>").text("Let's solve");
    var tag3 = document.createElement("strong");
    tag3.innerHTML = "We Believe in our beliefs";
    $("#img1").after(tag1,tag2,tag3);
    $("#img1").before(tag3,tag2,tag1);
}