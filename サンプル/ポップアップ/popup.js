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
