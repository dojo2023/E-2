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


const func = () => {
let score = 0;

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
console.log('現在の点数:'+ score);

}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("btn").addEventListener("click", function(){
    window.location.reload();
    })
});
