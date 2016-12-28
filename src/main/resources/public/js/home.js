addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}
$(function() {
	$("#slider").responsiveSlides({
		auto : true,
		nav : true,
		speed : 200,
		namespace : "callbacks",
		pager : true,
	});
	jQuery('.starbox')
			.each(
					function() {
						var starbox = jQuery(this);
						starbox
								.starbox(
										{
											average : starbox
													.attr('data-start-value'),
											changeable : starbox
													.hasClass('unchangeable') ? false
													: starbox
															.hasClass('clickonce') ? 'once'
															: true,
											ghosting : starbox
													.hasClass('ghosting'),
											autoUpdateAverage : starbox
													.hasClass('autoupdate'),
											buttons : starbox
													.hasClass('smooth') ? false
													: starbox
															.attr('data-button-count') || 5,
											stars : starbox
													.attr('data-star-count') || 5
										}).bind('starbox-value-changed',
										function(event, value) {
											if (starbox.hasClass('random')) {
												var val = Math.random();
												starbox.next().text(' ' + val);
												return val;
											}
										})
					});
	$('.value-plus1')
			.on(
					'click',
					function() {
						var divUpd = $(this).parent().find('.value1'), newVal = parseInt(
								divUpd.text(), 10) + 1;
						divUpd.text(newVal);
					});

	$('.value-minus1')
			.on(
					'click',
					function() {
						var divUpd = $(this).parent().find('.value1'), newVal = parseInt(
								divUpd.text(), 10) - 1;
						if (newVal >= 1)
							divUpd.text(newVal);
					});
});