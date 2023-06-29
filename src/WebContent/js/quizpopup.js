// ロード時にポップアップを隠す処理
$('.modal_pop').hide();
// ボタンクリック時にポップアップを表示する
  $('.show_pop').on('click',function(){
    $('.modal_pop').fadeIn();
  })
// ボタンクリック時にポップアップを非表示にする
  $('.js-modal-close').on('click',function(){
    $('.modal_pop').fadeOut();
  })

        const body = document.querySelector('body');
        const bgPopup = document.querySelector('.bg_onetime_popup');
        const popup = document.querySelector('.onetime_popup');
        const popupTitleClose = document.querySelector('.onetime_popup_title_close');
        body.classList.add('open_popup');

        bgPopup.addEventListener('click', function() {
            closePopup();
        });
        popup.addEventListener('click', function(e) {
            e.stopPropagation();
        });
        popupTitleClose.addEventListener('click', function() {
            closePopup();
        });

        function closePopup() {
            body.classList.remove('open_popup');
        }
const func = () => {
var hoge = document.getElementById( 'hoge' ).title; //現在のポイント

 console.log('現在の点数:'+ hoge);
 var allocation = 10;
 let result = 0;

const quiz_ans = document.getElementById('quiz');

  if (quiz_ans.radio.value == 'true') {
    var str = "正解";
    document.getElementById('edit_area').innerHTML = str ;
    result = parseInt(hoge) + parseInt(allocation);
  } else if (quiz_ans.radio.value == 'false') {
    var str = "不正解";
    document.getElementById('edit_area').innerHTML = str ;
    result = parseInt(hoge);
  }
    if (result == 0){
  	result = parseInt(hoge);
  }
   var qpoint = result;
console.log('現在の点数:'+ qpoint);
document.getElementById('quiz_point').innerHTML = qpoint ;

document.getElementById('get_point').value = qpoint;
  }
$('#get_point').hide();
