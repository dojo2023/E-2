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


$(function() {
  if($('#asgr-ticket').text() == "0"){
   $('.asigaru_pop').prop('disabled',true);
  $('.asgr_result-btn').prop('disabled',true);
  $('.asigaru_pop').css('background-color','rgb(116, 166, 216)');
  $('.asigaru_pop').css('box-shadow','rgb(49, 71, 198) 0px 10px 0px 0px');
  }
  if($('#smri-ticket').text() == "0"){
  $('.samurai_pop').prop('disabled',true);
  $('.smri_result-btn').prop('disabled',true);
  $('.samurai_pop').css('background-color','rgb(116, 166, 216)');
  $('.samurai_pop').css('box-shadow','rgb(49, 71, 198) 0px 10px 0px 0px');
  }
  if($('#sds-ticket').text() == "0"){
  $('.taisyou_pop').prop('disabled',true);
  $('.sds_result-btn').prop('disabled',true);
  $('.taisyou_pop').css('background-color','rgb(116, 166, 216)');
  $('.taisyou_pop').css('box-shadow','rgb(49, 71, 198) 0px 10px 0px 0px');
  $('.sds_result-btn').css('background-color','rgb(116, 166, 216)');
  $('.sds_result-btn').css('box-shadow','rgb(49, 71, 198) 0px 10px 0px 0px');
  }
});

