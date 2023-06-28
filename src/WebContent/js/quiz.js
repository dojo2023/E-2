//テスト
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
 var hoge = document.getElementById( 'hoge' ).title; //現在のポイント

 console.log('現在の点数:'+ hoge);
 var allocation = 3;
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


document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("btn").addEventListener("click", function(){
    window.location.reload();
    })
});





