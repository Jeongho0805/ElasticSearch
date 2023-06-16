const input = document.getElementById("keyword");
input.addEventListener('keypress', function(e){
    console.log(e.key);
    if(e.key === 'Enter'){
        search();
    }
})

const search = () => {
    initTableBody();
    let searchForm = document.getElementById("search-section");
    let searchText = searchForm.querySelector("#keyword").value;
    let searchType = searchForm.querySelector("#type").value;
    let queryString = 'searchText='+searchText+'&searchType='+searchType;
    console.log(queryString);

    fetch('http://localhost:8080/api/search?' + queryString, {
        method: 'GET'
    })
        .then(response => response.json())
        .then(data => {
            console.log(data)
            putData(data)
        })
        .catch(function(error) {
            console.error(error);
        });
}

const putData = (dataArray) => {
    console.log("데이터 길이 = " + dataArray.length);
    let list = document.getElementById("data-list");
    for (let i=0; i<dataArray.length; i++) {
        let tr = makeTableData(dataArray[i]);
        list.appendChild(tr);
    }
    let count = document.getElementById("data-count");
    count.innerText = dataArray.length + "개의 검색 결과";
}

const makeTableData = (data) => {
    let tr = document.createElement("tr");
    let tdArray = [];
    for (var i=0; i<9; i++) {
        tdArray.push(document.createElement("td"));
    }
    tdArray[0].innerText = data.occupation;
    tdArray[1].innerText = data.requiredExp;
    tdArray[2].innerText = data.address;
    tdArray[3].innerText = data.employType;
    tdArray[4].innerText = data.businessName;
    tdArray[5].innerText = data.wageType;
    tdArray[6].innerText = data.wage;
    tdArray[7].innerText = data.companyType;
    const parts = data.period.split('~');
    tdArray[8].innerText = "게시 " + parts[0] + "\n마감 " + parts[1];

    for (var i=0; i<9; i++) {
        tr.appendChild(tdArray[i]);
    }
    return tr;
}

const initTableBody = () => {
    let dataList = document.getElementById("data-list");
    while (dataList.firstChild) {
        dataList.removeChild(dataList.firstChild);
    }
}

const handleEnter = (e) => {
    if (e.keyCode === 13) {
        search();
    }
}