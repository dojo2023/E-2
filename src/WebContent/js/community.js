/**
 *
 */
  // ロード時に画面下固定
 window.scrollTo(0,document.body.scrollHeight);

 // ロード時にポップアップを隠す処理
 $('.editid').hide();
$('.modal_pop').hide();
// ボタンクリック時にポップアップを表示する
  $('.edit').on('click',function(){
    $('.modal_pop').fadeIn();
  })
// ボタンクリック時にポップアップを非表示にする
  $('.js-modal-close').on('click',function(){
    $('.modal_pop').fadeOut();
  })

  //削除ボタンを押したときに確認ダイアログ
  $('.delete').on('click',function(){
    window.confirm("投稿を削除してよろしいですか？")
  })


function editfun(edid){
var id = "textid"+ edid;
var text = $("#"+id).val()
$(".editarea").val(text);
$(".editid").val(edid);
console.log(text);
};

function replyfun(edid){
var id = "nameid"+ edid;
var name = $("#"+id).text()
console.log(name);
    $('.textarea').val("@"+name)
};
