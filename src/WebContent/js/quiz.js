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
 var hoge = document.getElementById( 'hoge' ).value;

 const quiz_ans = document.getElementById('quiz');
  if (quiz_ans.radio.value == 'true') {
    var str = "正解";
    document.getElementById('edit_area').innerHTML = str ;
    hoge++;
  } else if (quiz_ans.radio.value == 'false') {
    var str = "不正解";
    document.getElementById('edit_area').innerHTML = str ;
  }
 var qpoint = hoge;
console.log('現在の点数:'+ qpoint);
document.getElementById('quiz_point').innerHTML = qpoint ;

}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("btn").addEventListener("click", function(){
    window.location.reload();
    })
});
