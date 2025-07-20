async function RetriveSpecificDropdownData(chosenCategory){
    try{
        console.log("Retriving data for dropdwon")
        const url = "http://localhost:8080/v1ConfigurationController/retriveParts"
        let catagory = chosenCategory;
         let response = await fetch(url, {
            method: "Post",
             headers: {
             "Content-Type": "application/json"
            },
            body : JSON.stringify({"category" : catagory})
          }) 
            const data = await response.json();
            return data
            // let Firstitem = data[1];

            // console.log(Firstitem.partName);

    }catch{
        alert("fetch request failed");
        console.log("error in fetch request")
        

    }

}
function PopulateSpecificDropdownHtmlWithOptions(targetDropdownBox, options) {
    const dropdown = document.getElementById(targetDropdownBox);
    dropdown.innerHTML = "";

    options.forEach(option => {
        const opt = document.createElement("option");
        opt.value = option.partId;     
        opt.text = option.partName;  
        dropdown.appendChild(opt);
    });
}
//need a function that uses both of these to fill all drop down boxes

function PopulateAllDropdowns(){
    const dropdowns = ["CPU", "Motherboard", "GPU", "RAM", "Storage", "PSU", "Case", "Cooling"];
    dropdowns.forEach(async dropdown => {
        dropdownDataAvailible = await RetriveSpecificDropdownData(dropdown);
        PopulateSpecificDropdownHtmlWithOptions(dropdown,dropdownDataAvailible);
    })
}

async function RetrivePriceData(){
    try{
        console.log("Retriving Pricing")
        const url = "http://localhost:8080/v1ConfigurationController/ReturnCost"
        let cpu = document.getElementById("CPU").value;
        let motherboard = document.getElementById("Motherboard").value;
        let gpu = document.getElementById("GPU").value;
        let ram  = document.getElementById("RAM").value;
        let storage = document.getElementById("Storage").value;
        let psu = document.getElementById("PSU").value;
        let caseUnit = document.getElementById("Case").value;
        let cooler = document.getElementById("Cooling").value
         let response = await fetch(url, {
            method: "Post",
             headers: {
             "Content-Type": "application/json"
            },
            body : JSON.stringify({
                "cpuId" : cpu,
                "motherboardId" : motherboard,
                "gpuId" : gpu,
                "ramId" : ram,
                "storageId" : storage,
                "psuId" : psu,
                "caseId" : caseUnit,
                "coolerId" : cooler
            })
          }) 
            const data = await response.json();
            console.log("Receipt Breakdown:");
            console.log("Subtotal: £" + data.subtotal);
            console.log("VAT Due: £" + data.vatDue);
            console.log("Tax Due: £" + data.taxDue);
            console.log("Grand Total: £" + data.grandtotalDue);
            document.getElementById("preVat").innerText = data.subtotal;
            document.getElementById("vat").innerText = data.taxDue;
            document.getElementById("total").innerText = data.grandtotalDue;
            return data
            // let Firstitem = data[1];

            // console.log(Firstitem.partName);

    }catch{
        alert("fetch request failed");
        console.log("error in fetch request")
        

    }

}

// function PopulateAllPricingData(){
//     pricingData = RetrivePriceData();
//     document.getElementById("preVat").innerText = pricingData.subtotal;
//     document.getElementById("vat").innerText = pricingData.tax;
//     document.getElementById("total").innerText = pricingData.grandtotal;

// }

window.onload = PopulateAllDropdowns()

console.log("DOMLoaded")


document.addEventListener("DOMContentLoaded", () => {
console.log("DOM fully loaded and parsed");
document.getElementById("CPU").addEventListener('change',RetrivePriceData)
document.getElementById("Motherboard").addEventListener('change',RetrivePriceData)
document.getElementById("GPU").addEventListener('change',RetrivePriceData)
document.getElementById("RAM").addEventListener('change',RetrivePriceData)
document.getElementById("Storage").addEventListener('change',RetrivePriceData)
document.getElementById("PSU").addEventListener('change',RetrivePriceData)
document.getElementById("Case").addEventListener('change',RetrivePriceData)
document.getElementById("Cooling").addEventListener('change',RetrivePriceData)

});

async function OrderPc(){

    let cpu = document.getElementById("CPU").value;
    let motherboard = document.getElementById("Motherboard").value;
    let gpu = document.getElementById("GPU").value;
    let ram  = document.getElementById("RAM").value;
    let storage = document.getElementById("Storage").value;
    let psu = document.getElementById("PSU").value;
    let caseUnit = document.getElementById("Case").value;
    let cooler = document.getElementById("Cooling").value;
    let name = document.getElementById("custName").value;
    let email = document.getElementById("custEmail").value;
    let phone = document.getElementById("custPhone").value;
    let address = document.getElementById("custAddress").value;

    console.log("Customer Name:", name);
    console.log("Email:", email);
    console.log("Phone:", phone);
    console.log("Address:", address);

    console.log("Selected IDs:");
    console.log("CPU:", cpu);
    console.log("Motherboard:", motherboard);
    console.log("GPU:", gpu);
    console.log("RAM:", ram);
    console.log("Storage:", storage);
    console.log("PSU:", psu);
    console.log("Case:", caseUnit);
    console.log("Cooler:", cooler);
    // Validation check
let missingFields = [];

if (!cpu) missingFields.push("CPU");
if (!motherboard) missingFields.push("Motherboard");
if (!gpu) missingFields.push("GPU");
if (!ram) missingFields.push("RAM");
if (!storage) missingFields.push("Storage");
if (!psu) missingFields.push("PSU");
if (!caseUnit) missingFields.push("Case");
if (!cooler) missingFields.push("Cooler");
if (!name) missingFields.push("Name");
if (!email) missingFields.push("Email");
if (!phone) missingFields.push("Phone");
if (!address) missingFields.push("Address");

if (missingFields.length > 0) {
    alert("The following fields are missing or not selected:\n- " + missingFields.join("\n- "));
    return; // stop fucntion and detail what fields are missing using array legnth measuring
} else {
    let response = await fetch("http://localhost:8080/v1OrderingController/ReturnOrderNumber", {
    method: "Post",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify(
    {
    "customer": 
    {
    "name": name,
    "email": email,
    "phoneNumber": phone,
    "shippingAddress": address
    },
    "rawBuild": 
    {
    "cpuId": cpu,
    "gpuId": gpu,
    "ramId": ram,
    "storageId": storage,
    "motherboardId": motherboard,
    "psuId": psu,
    "caseId": caseUnit,
    "coolerId": cooler
    }
    }
)
})
let data = await response.json()
console.log("Order number is: " + data.orderNumber)
document.getElementById("orderNumberDisplay").textContent = data.orderNumber;
document.getElementById("orderConfirmation").style.display = "block";
}
}



