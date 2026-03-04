$(document).ready(function () {
    console.log("Data-Handler Loaded");
    let tbody = $("#dataTable  tbody");
    tbody.empty();

    $.ajax({
        url: "data/userdata",
        method: "POST",
        success: function (data) {
            data.forEach(item => {

                    let tr = $("<tr></tr>");
                    tr.append($("<td></td>").text(item.id));
                    tr.append($("<td></td>").text(item.name));
                    tr.append($("<td></td>").text(item.amount));
                    tr.append($("<td></td>").text(item.date));
                    tr.append($("<td></td>").text(item.type));
                    tr.append($("<td></td>").text(item.PaymentMethod));
                    tr.append($("<td></td>").text(item.Category));
                    tr.append($("<td></td>").text(item.note));
                    tbody.append(tr);
                }
            )
            console.log(item.id + " : " + item.name + " : " + item.amount)
        }
    })
})