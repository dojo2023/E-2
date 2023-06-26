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

const quiz_ans = document.getElementById('quiz');

  if (quiz_ans.radio.value == 'true') {
    alert("正解");
    var str = "正解";
    document.getElementById('edit_area').innerHTML = str ;
    score++;
  } else if (quiz_ans.radio.value == 'false') {
    alert("不正解");
    var str = "不正解";
    document.getElementById('edit_area').innerHTML = str ;
  }
  }
