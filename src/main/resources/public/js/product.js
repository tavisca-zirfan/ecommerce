$(window)
		.load(
				function() {
					$('.flexslider').flexslider({
						animation : "slide",
						controlNav : "thumbnails"
					});
					$('.value-plus1')
							.on(
									'click',
									function() {
										var divUpd = $(this).parent().find(
												'.value1'), newVal = parseInt(
												divUpd.text(), 10) + 1;
										divUpd.text(newVal);
									});

					$('.value-minus1')
							.on(
									'click',
									function() {
										var divUpd = $(this).parent().find(
												'.value1'), newVal = parseInt(
												divUpd.text(), 10) - 1;
										if (newVal >= 1)
											divUpd.text(newVal);
									});
					$(".owl-demo").owlCarousel({
						items : 1,
						autoPlay : true,
						navigation : false,
						navigationText : false,
						pagination : true,
					});
					
					
				});
