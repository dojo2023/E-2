/**
 *
 */
  // ロード時に画面下固定
 window.scrollTo(0,document.body.scrollHeight);

 // ロード時にポップアップを隠す処理
$('.modal_pop').hide();
// ボタンクリック時にポップアップを表示する
  $('.edit').on('click',function(){
    $('.modal_pop').fadeIn();
  })
// ボタンクリック時にポップアップを非表示にする
  $('.js-modal-close').on('click',function(){
    $('.modal_pop').fadeOut();
  })

  //返信クリック時にメンションができる
  $('.reply').on('click',function(){
    var name = $('.name').text();
    $('.textarea').val("@"+name)
  })

  //削除ボタンを押したときに確認ダイアログ
  $('.delete').on('click',function(){
    if(window.confirm("投稿を削除してよろしいですか？")){
      window.alert("投稿を削除しました。");
    }
  })

function editfun(edid){
var id = "textid"+ edid;
var text = $("#"+id).val()
$(".editarea").val(text);
$(".editid").val(edid);
console.log(text);
};
