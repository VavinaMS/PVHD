function SaveKtStart(value, id, resultId) {
    var object = {ktStart:value,ID:id};
    $.ajax("saveKtStart",
        {
            type:"GET",
            dataType: 'json',
            data: object,
            success: function (response) {
                $("#ktEnd"+resultId).val(response);
            }
        });
}

function SaveProsrochStart(value, id) {
    var object = {prosrochStart:value,ID:id};
    jQuery.ajax("saveProsrochStart",
        {
            type:"POST",
            data: object
        });
}

function SaveViplacheno(value, id, resultId) {
    var object = {viplocheno:value,ID:id};
    jQuery.ajax("saveViplacheno",
        {
            type:"POST",
            data: object,
            success: function (response) {
                $("#ktEnd"+resultId).val(response);
            }
        });
}

function SaveOplacheno(value, id, resultId) {
    var object = {oplacheno:value,ID:id};
    jQuery.ajax("saveOplacheno",
        {
            type:"POST",
            data: object,
            success: function (response) {
                $("#ktEnd"+resultId).val(response);
            }
        });
}

function SaveKtEnd(value, id) {
    var object = {ktEnd:value,ID:id};
    jQuery.ajax("saveKtEnd",
        {
            type:"POST",
            data: object
        });
}

function SaveProsrochEnd(value, id) {
    var object = {prosrochEnd:value,ID:id};
    jQuery.ajax("saveProsrochEnd",
        {
            type:"POST",
            data: object
        });
}

function GetIDReport(id) {
    var object = {ID:id};
    jQuery.ajax("idToSession",
        {
            type:"POST",
            data: object
        });
    location.reload(true);
}

function GetSummktStart(idReport, idStat) {
    var object = {ID:idReport};
    //223
    if (idStat == 9 || idStat == 11 || idStat == 13 || idStat == 15 || idStat == 16) {

        var summ = Number($("#ktStart9").val()) + Number($("#ktStart11").val()) + Number($("#ktStart13").val()) + Number($("#ktStart15").val()) + Number($("#ktStart16").val());
        $("#ktStart8").val(summ);
    }
    //290
    if (idStat == 23 || idStat == 24 || idStat == 25 || idStat == 26 || idStat == 27) {

        var summ = Number($("#ktStart23").val()) + Number($("#ktStart24").val()) + Number($("#ktStart25").val()) + Number($("#ktStart26").val()) + Number($("#ktStart27").val());
        $("#ktStart22").val(summ);
    }
    //340
    if (idStat == 30 || idStat == 31 || idStat == 32 || idStat == 33 || idStat == 34 || idStat == 35 || idStat == 36 || idStat == 37) {

        var summ = Number($("#ktStart30").val()) + Number($("#ktStart31").val()) + Number($("#ktStart32").val()) + Number($("#ktStart33").val()) + Number($("#ktStart34").val()) + Number($("#ktStart35").val()) + Number($("#ktStart36").val()) + Number($("#ktStart37").val());
        $("#ktStart29").val(summ);
    }
    //Всего
    if (idStat == 3 || idStat == 4 || idStat == 5 || idStat == 6 || idStat == 7 || idStat == 8 || idStat == 17 || idStat == 18 || idStat == 19 || idStat == 21 || idStat == 22 || idStat == 28 || idStat == 29) {

        var summ = Number($("#ktStart3").val()) + Number($("#ktStart4").val()) + Number($("#ktStart5").val()) + Number($("#ktStart6").val()) + Number($("#ktStart7").val()) + Number($("#ktStart8").val()) + Number($("#ktStart17").val()) + Number($("#ktStart18").val())
            + Number($("#ktStart19").val()) + Number($("#ktStart21").val()) + Number($("#ktStart22").val()) + Number($("#ktStart28").val()) + Number($("#ktStart29").val());
        $("#ktStart38").val(summ);
    }
    //Остаток на конец
    if (idStat == 1 || idStat == 2){
        alert(Number($("#ktStart1").val()) +" "+ Number($("#ktStart2").val())+" "+ Number($("#oplacheno38").val()))
        var summ = Number($("#ktStart1").val()) + Number($("#ktStart2").val()) - Number($("#oplacheno38").val());
        $("#ktStart39").val(summ);
    }
}

function GetSummProsrochStart(idReport, idStat) {
    var object = {ID:idReport};
    if (idStat == 9 || idStat == 11 || idStat == 13 || idStat == 15 || idStat == 16) {

        var summ = Number($("#prosrochStart9").val()) + Number($("#prosrochStart11").val()) + Number($("#prosrochStart13").val()) + Number($("#prosrochStart15").val()) + Number($("#prosrochStart16").val());
        $("#prosrochStart8").val(summ);
    }

    //290
    if (idStat == 23 || idStat == 24 || idStat == 25 || idStat == 26 || idStat == 27) {

        var summ = Number($("#prosrochStart23").val()) + Number($("#prosrochStart24").val()) + Number($("#prosrochStart25").val()) + Number($("#prosrochStart26").val()) + Number($("#prosrochStart27").val());
        $("#prosrochStart22").val(summ);
    }
    //340
    if (idStat == 30 || idStat == 31 || idStat == 32 || idStat == 33 || idStat == 34 || idStat == 35 || idStat == 36 || idStat == 37) {

        var summ = Number($("#prosrochStart30").val()) + Number($("#prosrochStart31").val()) + Number($("#prosrochStart32").val()) + Number($("#prosrochStart33").val()) + Number($("#prosrochStart34").val()) + Number($("#prosrochStart35").val()) + Number($("#prosrochStart36").val()) + Number($("#prosrochStart37").val());
        $("#prosrochStart29").val(summ);
    }
    //Всего
    if (idStat == 3 || idStat == 4 || idStat == 5 || idStat == 6 || idStat == 7 || idStat == 8 || idStat == 17 || idStat == 18 || idStat == 19 || idStat == 21 || idStat == 22 || idStat == 28 || idStat == 29) {

        var summ = Number($("#prosrochStart3").val()) + Number($("#prosrochStart4").val()) + Number($("#prosrochStart5").val()) + Number($("#prosrochStart6").val()) + Number($("#prosrochStart7").val()) + Number($("#prosrochStart8").val()) + Number($("#prosrochStart17").val()) + Number($("#prosrochStart18").val())
            + Number($("#prosrochStart19").val()) + Number($("#prosrochStart21").val()) + Number($("#prosrochStart22").val()) + Number($("#prosrochStart28").val()) + Number($("#prosrochStart29").val());
        $("#prosrochStart38").val(summ);
    }
}

function GetSummVistavleno(idReport, idStat) {
    var object = {ID:idReport};
    if (idStat == 9 || idStat == 11 || idStat == 13 || idStat == 15 || idStat == 16) {

        var summ = Number($("#vistavleno9").val()) + Number($("#vistavleno11").val()) + Number($("#vistavleno13").val()) + Number($("#vistavleno15").val()) + Number($("#vistavleno16").val());
        $("#vistavleno8").val(summ);
    }
    //290
    if (idStat == 23 || idStat == 24 || idStat == 25 || idStat == 26 || idStat == 27) {

        var summ = Number($("#vistavleno23").val()) + Number($("#vistavleno24").val()) + Number($("#vistavleno25").val()) + Number($("#vistavleno26").val()) + Number($("#vistavleno27").val());
        $("#vistavleno22").val(summ);
    }
    //340
    if (idStat == 30 || idStat == 31 || idStat == 32 || idStat == 33 || idStat == 34 || idStat == 35 || idStat == 36 || idStat == 37) {

        var summ = Number($("#vistavleno30").val()) + Number($("#vistavleno31").val()) + Number($("#vistavleno32").val()) + Number($("#vistavleno33").val()) + Number($("#vistavleno34").val()) + Number($("#vistavleno35").val()) + Number($("#vistavleno36").val()) + Number($("#vistavleno37").val());
        $("#vistavleno29").val(summ);
    }
    //Всего
    if (idStat == 3 || idStat == 4 || idStat == 5 || idStat == 6 || idStat == 7 || idStat == 8 || idStat == 17 || idStat == 18 || idStat == 19 || idStat == 21 || idStat == 22 || idStat == 28 || idStat == 29) {

        var summ = Number($("#vistavleno3").val()) + Number($("#vistavleno4").val()) + Number($("#vistavleno5").val()) + Number($("#vistavleno6").val()) + Number($("#vistavleno7").val()) + Number($("#vistavleno8").val()) + Number($("#vistavleno17").val()) + Number($("#vistavleno18").val())
            + Number($("#vistavleno19").val()) + Number($("#vistavleno21").val()) + Number($("#vistavleno22").val()) + Number($("#vistavleno28").val()) + Number($("#vistavleno29").val());
        $("#vistavleno38").val(summ);
    }
}

function GetSummOplacheno(idReport, idStat) {
    var object = {ID:idReport};
    if (idStat == 9 || idStat == 11 || idStat == 13 || idStat == 15 || idStat == 16) {

        var summ = Number($("#oplacheno9").val()) + Number($("#oplacheno11").val()) + Number($("#oplacheno13").val()) + Number($("#oplacheno15").val()) + Number($("#oplacheno16").val());
        $("#oplacheno8").val(summ);
    }

    //290
    if (idStat == 23 || idStat == 24 || idStat == 25 || idStat == 26 || idStat == 27) {

        var summ = Number($("#oplacheno23").val()) + Number($("#oplacheno24").val()) + Number($("#oplacheno25").val()) + Number($("#oplacheno26").val()) + Number($("#oplacheno27").val());
        $("#oplacheno22").val(summ);
    }
    //340
    if (idStat == 30 || idStat == 31 || idStat == 32 || idStat == 33 || idStat == 34 || idStat == 35 || idStat == 36 || idStat == 37) {

        var summ = Number($("#oplacheno30").val()) + Number($("#oplacheno31").val()) + Number($("#oplacheno32").val()) + Number($("#oplacheno33").val()) + Number($("#oplacheno34").val()) + Number($("#oplacheno35").val()) + Number($("#oplacheno36").val()) + Number($("#oplacheno37").val());
        $("#oplacheno29").val(summ);
    }
    //Всего
    if (idStat == 3 || idStat == 4 || idStat == 5 || idStat == 6 || idStat == 7 || idStat == 8 || idStat == 17 || idStat == 18 || idStat == 19 || idStat == 21 || idStat == 22 || idStat == 28 || idStat == 29) {

        var summ = Number($("#oplacheno3").val()) + Number($("#oplacheno4").val()) + Number($("#oplacheno5").val()) + Number($("#oplacheno6").val()) + Number($("#oplacheno7").val()) + Number($("#oplacheno8").val()) + Number($("#oplacheno17").val()) + Number($("#oplacheno18").val())
            + Number($("#oplacheno19").val()) + Number($("#oplacheno21").val()) + Number($("#oplacheno22").val()) + Number($("#oplacheno28").val()) + Number($("#oplacheno29").val());
        $("#oplacheno38").val(summ);
    }
}

function GetSummktEnd(idReport, idStat) {
    var object = {ID:idReport};
    if (idStat == 9 || idStat == 11 || idStat == 13 || idStat == 15 || idStat == 16) {

        var summ = Number($("#ktEnd9").val()) + Number($("#ktEnd11").val()) + Number($("#ktEnd13").val()) + Number($("#ktEnd15").val()) + Number($("#ktEnd16").val());
        $("#ktEnd8").val(summ);
    }

    //290
    if (idStat == 23 || idStat == 24 || idStat == 25 || idStat == 26 || idStat == 27) {

        var summ = Number($("#ktEnd23").val()) + Number($("#ktEnd24").val()) + Number($("#ktEnd25").val()) + Number($("#ktEnd26").val()) + Number($("#ktEnd27").val());
        $("#ktStart22").val(summ);
    }
    //340
    if (idStat == 30 || idStat == 31 || idStat == 32 || idStat == 33 || idStat == 34 || idStat == 35 || idStat == 36 || idStat == 37) {

        var summ = Number($("#ktEnd30").val()) + Number($("#ktEnd31").val()) + Number($("#ktEnd32").val()) + Number($("#ktEnd33").val()) + Number($("#ktEnd34").val()) + Number($("#ktEnd35").val()) + Number($("#ktEnd36").val()) + Number($("#ktEnd37").val());
        $("#ktEnd29").val(summ);
    }
    //Всего
    if (idStat == 3 || idStat == 4 || idStat == 5 || idStat == 6 || idStat == 7 || idStat == 8 || idStat == 17 || idStat == 18 || idStat == 19 || idStat == 21 || idStat == 22 || idStat == 28 || idStat == 29) {

        var summ = Number($("#ktEnd3").val()) + Number($("#ktEnd4").val()) + Number($("#ktEnd5").val()) + Number($("#ktEnd6").val()) + Number($("#ktEnd7").val()) + Number($("#ktEnd8").val()) + Number($("#ktEnd17").val()) + Number($("#ktEnd18").val())
            + Number($("#ktEnd19").val()) + Number($("#ktEnd21").val()) + Number($("#ktEnd22").val()) + Number($("#ktEnd28").val()) + Number($("#ktEnd29").val());
        $("#ktEnd38").val(summ);
    }
}

function GetSummprosrochEnd(idReport, idStat) {
    var object = {ID:idReport};
    if (idStat == 9 || idStat == 11 || idStat == 13 || idStat == 15 || idStat == 16) {

        var summ = Number($("#prosrochEnd9").val()) + Number($("#prosrochEnd11").val()) + Number($("#prosrochEnd13").val()) + Number($("#prosrochEnd15").val()) + Number($("#prosrochEnd16").val());
        $("#prosrochEnd8").val(summ);
    }

    //290
    if (idStat == 23 || idStat == 24 || idStat == 25 || idStat == 26 || idStat == 27) {

        var summ = Number($("#prosrochEnd23").val()) + Number($("#prosrochEnd24").val()) + Number($("#prosrochEnd25").val()) + Number($("#prosrochEnd26").val()) + Number($("#prosrochEnd27").val());
        $("#prosrochEnd22").val(summ);
    }
    //340
    if (idStat == 30 || idStat == 31 || idStat == 32 || idStat == 33 || idStat == 34 || idStat == 35 || idStat == 36 || idStat == 37) {

        var summ = Number($("#prosrochEnd30").val()) + Number($("#prosrochEnd31").val()) + Number($("#prosrochEnd32").val()) + Number($("#prosrochEnd33").val()) + Number($("#prosrochEnd34").val()) + Number($("#prosrochEnd35").val()) + Number($("#prosrochEnd36").val()) + Number($("#prosrochEnd37").val());
        $("#prosrochEnd29").val(summ);
    }
    //Всего
    if (idStat == 3 || idStat == 4 || idStat == 5 || idStat == 6 || idStat == 7 || idStat == 8 || idStat == 17 || idStat == 18 || idStat == 19 || idStat == 21 || idStat == 22 || idStat == 28 || idStat == 29) {

        var summ = Number($("#prosrochEnd3").val()) + Number($("#prosrochEnd4").val()) + Number($("#prosrochEnd5").val()) + Number($("#prosrochEnd6").val()) + Number($("#prosrochEnd7").val()) + Number($("#prosrochEnd8").val()) + Number($("#prosrochEnd17").val()) + Number($("#prosrochEnd18").val())
            + Number($("#prosrochEnd19").val()) + Number($("#prosrochEnd21").val()) + Number($("#prosrochEnd22").val()) + Number($("#prosrochEnd28").val()) + Number($("#prosrochEnd29").val());
        $("#prosrochEnd38").val(summ);
    }
}

//-------Ежемесячные
function GetIDReportMonthly(id) {
    var object = {ID:id};
    jQuery.ajax("idToSessionMonthly",
        {
            type:"POST",
            data: object
        });
    location.reload(true);
}

$(document).ready(function(){
    $("#browser").treeview();
});