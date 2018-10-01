/**
 * 
 */

$(document).ready(function(){
	
	$('.eBtn, .table .eBtn').on('click',function(event){
		event.preventDefault();
		
		var href=$(this).attr('href');
		
		var text =$(this).text();

		if(text=='Edit'){
		$.get(href,function(teacher,status){

			$('.myForm #id').val(teacher.email);
			$('.myForm #countryName').val(teacher.name);
			$('.myForm #countryCapital').val(teacher.password);
		});

		$('.myForm #exampleModal').modal();
		}
		else{
			$('.myForm #id').val('');
			$('.myForm #countryName').val('');
			$('.myForm #countryCapital').val('');
			$('.myForm #exampleModal').modal();
		}
	});
	
	$('.table .delBtn').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteModal #delRef').attr('href',href);
		$('#deleteModal').modal();
	});
	
	
});