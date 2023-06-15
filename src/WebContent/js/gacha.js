/**
 *
 */
 // ロード時にポップアップを隠す処理
$('.modal_pop').hide();
$('.modal_pop2').hide();
$('.modal_pop_main2').hide();
// ボタンクリック時にポップアップを表示する
  $('.asigaru_pop').on('click',function(){
    $('.modal_pop').fadeIn();
  })
  $('.samurai_pop').on('click',function(){
    $('.modal_pop').fadeIn();
  })
  $('.taisyou_pop').on('click',function(){
    $('.modal_pop').fadeIn();
  })
// ボタンクリック時にポップアップを非表示にする
  $('.js-modal-close').on('click',function(){
    $('.modal_pop').fadeOut();
  })


  // ボタンクリック時にポップアップ2を表示する
  $('.gacha-modal2-open').on('click',function(){
    $('.modal_pop2').fadeIn();
  })
// ボタンクリック時にポップアップ2を非表示にする
  $('.js-modal2-close').on('click',function(){
    $('.modal_pop').fadeOut();
    $('.modal_pop2').fadeOut();
  })