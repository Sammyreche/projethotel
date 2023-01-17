alert('ok');
var etat = "off";
function ChangeBackgroundColorNav() {
    if (etat == "off") {
        document.getElementById("navbar").style.backgroundColor =
            "rgba(241, 215, 195)";
        etat = "on";
    } else if (etat == "on") {
        document.getElementById("navbar").style.backgroundColor =
            "rgba(241, 215, 195,0)";
        etat = "off";
    }
}

function changeColorMouse(x) {
    x.style.backgroundColor = "#ffffff";
}
function changeColorMouseBack(x) {
    x.style.backgroundColor = "#f1d7c3";
}
$.fn.datepicker.dates["fr"] = {
    days: [
        "Lundi",
        "Mardi",
        "Mercredi",
        "Jeudi",
        "Vendredi",
        "Samedi",
        "Dimanche",
    ],
    daysShort: ["Lan", "Mar", "Mer", "Jeu", "Vend", "Sam", "Dim"],
    daysMin: ["L", "M", "Me", "J", "V", "S", "D"],
    months: [
        "Janvier",
        "Février",
        "Mars",
        "Avril",
        "Mai",
        "Juin",
        "Juillet",
        "Aout",
        "Septembre",
        "Octobre",
        "Novembre",
        "Décembre",
    ],
    monthsShort: [
        "Jan",
        "Fév",
        "Mar",
        "Avr",
        "Mai",
        "Juin",
        "Juil",
        "Aou",
        "Sep",
        "Oct",
        "Nov",
        "Dec",
    ],
    today: "Today",
    clear: "Clear",
    format: "dd/mm/yyyy",
    titleFormat: "MM yyyy" /* Leverages same syntax as 'format' */,
    weekStart: 0,
};
$("#dateArv")
    .datepicker({
        startDate: "Today",
        todayHighlight: true,
        autoclose: true,
        language: "fr",
    })
    .on("changeDate", function (e) {
        $("#dateDep").datepicker("setStartDate", e.date);
        $("#dateDep").focus();
    });
$("#dateDep").datepicker({
    todayHighlight: true,
    autoclose: true,
    language: "fr",
});

var nav = document.querySelector("nav");
window.addEventListener("scroll", function () {
    if (window.pageYOffset > 1) {
        document.getElementById("navbar").style.backgroundColor =
            "rgba(241, 215, 195)";
    } else if (window.pageYOffset < 1 && etat == "off") {
        document.getElementById("navbar").style.backgroundColor =
            "rgba(241, 215, 195,0)";
    }
});

function affichagePlus() {
    document.getElementById("equipe").style.display = "flex";
    document.getElementById("plus").style.display = "none";
    document.getElementById("moins").style.display = "flex";
}
function affichageMoins() {
    document.getElementById("equipe").style.display = "none";
    document.getElementById("plus").style.display = "flex";
    document.getElementById("moins").style.display = "none";
}