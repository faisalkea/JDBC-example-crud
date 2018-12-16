function test(){
    alert("test");
}

$(document).ready(test);

$(document).ready(function () {
    $("#toggleButton").click(function () {
        $("#create").toggle();
    });

    $("#clear").click(function () {
        $("#blogs").text("");
    });

});

$("#data").click(function () {
    $.ajax(
        {
            url: "/user/ajax",
            success: function (result) {
                console.log(result);
                $("#blogs").text(result);
            },
            failure: console.log("didn't work!")
        });
});

// Timer
setInterval(function() {
    $.ajax(
        {
            url: "/user/ajax",
            success: function (result) {
                console.log(result)
                $("#blogs").text(result);
            },
            failure: console.log("didn't work!")
        });
}, 5000);
