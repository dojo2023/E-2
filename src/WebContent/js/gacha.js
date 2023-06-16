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
    $('.asigacha').show();
    $('.samugacha').hide();
    $('.taigacha').hide();
  })
  $('.samurai_pop').on('click',function(){
    $('.modal_pop').fadeIn();
    $('.asigacha').hide();
    $('.samugacha').show();
    $('.taigacha').hide();
  })
  $('.taisyou_pop').on('click',function(){
    $('.modal_pop').fadeIn();
    $('.asigacha').hide();
    $('.samugacha').hide();
    $('.taigacha').show();
  })
// ボタンクリック時にポップアップを非表示にする
  $('.js-modal-close').on('click',function(){
    $('.modal_pop').fadeOut();
  })
