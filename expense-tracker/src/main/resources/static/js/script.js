$(document).ready(function(){
    console.log("Javascript Loaded");

    $("#type").on("change",function (){
        let selectedCategory  = $(this).val();
        let catSelector = $("#category");
        catSelector.empty()
        catSelector.append("<option value=''> Select</option>");
            $.ajax({
                url: "/data/categorydata",
                method : "POST",
                data: { selectedValue : selectedCategory},
                success(data){
                    $.each(data, function (key,value) {
                        catSelector.append(
                            $("<option></option>").val(key).text(value)
                        );
                    })
                },
                error(xhr,status,error){
                    console.log("Server GIve Error with Status Code: "+status+"Error"+error);
                }
            })





        $("#dataDoor").on("click",function(){
            window.location.href="/data";
        });
    })
    })

