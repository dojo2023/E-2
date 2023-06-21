/**
 *
 */
 function hamburger() {
    document.getElementById('line1').classList.toggle('line_1');
    document.getElementById('line2').classList.toggle('line_2');
    document.getElementById('line3').classList.toggle('line_3');
    document.getElementById('nav').classList.toggle('in');
  }
  document.getElementById('hamburger').addEventListener('click' , function () {
    hamburger();
    document.getElementById('css').disabled = false;
  } );


//shisakuhin
const buttonOpen = document.getElementById('modalOpen');
const modal = document.getElementById('easyModal');
const buttonClose = document.getElementsByClassName('modalClose')[0];

// ボタンがクリックされた時
buttonOpen.addEventListener('click', modalOpen);
function modalOpen() {
  modal.style.display = 'block';
}

// バツ印がクリックされた時
buttonClose.addEventListener('click', modalClose);
function modalClose() {
  modal.style.display = 'none';
}


// モーダルコンテンツ以外がクリックされた時


document.addEventListener("click",(e)=>{
  if(e.target == modal){
    modal.style.display ="none";
  }
});
//マーク設定ボタン マーク設定ボタン マーク設定ボタン マーク設定ボタン
const button2Open = document.getElementById('modalOpen2');
const modal2 = document.getElementById('easyModal2');
const button2Close = document.getElementsByClassName('modalClose2')[0];

// ボタンがクリックされた時
button2Open.addEventListener('click', modalOpen2);
function modalOpen2() {
  modal2.style.display = 'block';
}

// バツ印がクリックされた時
button2Close.addEventListener('click', modalClose2);
function modalClose2() {
  modal2.style.display = 'none';
}

// モーダルコンテンツ以外がクリックされた時
addEventListener('click', outsideClose);
function outsideClose(e) {
  if (e.target == modal2) {
    modal2.style.display = 'none';
  }
}
//マーク設定のプルダウン
