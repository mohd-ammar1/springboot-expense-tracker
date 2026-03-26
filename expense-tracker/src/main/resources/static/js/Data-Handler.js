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



    $("#filterBtn").on("click", function () {
        //Getting Values

        var date = new Date($("#datef").val());
        seldate = date.getDate();
        selmonth = date.getMonth();
        selyear = date.getFullYear();
        const day = String(seldate).padStart(2, '0');
        const month = String(selmonth).padStart(2, '0');

        var nameVal = $("#namef").val().trim() || null;        // name input
        var amountVal = $("#amountf").val().trim() || null;    // amount input
        var amountTypeVal = $("#amountsel").val().trim() || null; // amount type dropdown

        var finalDateVal = `${selyear}-${month}-${day}`;
        if (!seldate || !selmonth || !selyear) finalDateVal = null;
        var dateTypeVal = $("#datesel").val().trim() || null;  // date type dropdown
        var typeSltVal = $("#typeselect").val().trim() || null; // type select (income/expense)
        var methodVal = $("#pmethodsel").val().trim() || null;  // payment method dropdown

        // Print all values for debugging
        console.log("Name:", nameVal);
        console.log("Amount:", amountVal);
        console.log("Amount Type:", amountTypeVal);
        console.log("Final Date:", finalDateVal);
        console.log("Date Type:", dateTypeVal);
        console.log("Type Selected:", typeSltVal);
        console.log("Payment Method:", methodVal);

        //  Create data object to convert into josn
        var data = {
            name: nameVal,
            amount: amountVal,
            amountType: amountTypeVal,
            finaldate: finalDateVal,
            datetype: dateTypeVal,
            typeslt: typeSltVal,
            method: methodVal
        };
        jsondata = JSON.stringify(data, null, 2);

        $.ajax({
            url: "data/sort",
            method: "POST",
            data: jsondata,
            contentType: "application/json",
            success: function (data) {
                tbody.empty();
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
            , error: function () {
                console.log("Error Occured")
            }

        })
    });
    console.log("Name", name, " \n Amount:", amount, "\n Amount type:", amounttype, "\nDate:", finaldate, "\nDate Type:", datetype, "\nType:", typeslt, "\nPayment Method: ", method)
})


