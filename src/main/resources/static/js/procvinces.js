function procvince(procvinces,districts){

    document.getElementById('address_1').value= procvinces;
    document.getElementById('address_2').value= districts;

    $('select[name="calc_shipping_provinces"]').each(function () {
        var $this = $(this),
            stc = ''
        c.forEach(function (i, e) {
            e += +1
            stc += '<option value="' + e + '">' + i + '</option>'
            $this.html('<option value="">Tỉnh / Thành phố</option>' + stc)

            if(procvinces != null && procvinces.length > 1) {
                $('select[name="calc_shipping_provinces"] option').each(function () {
                    if ($(this).text() == procvinces) {
                        $(this).attr('selected', '')
                    }
                })
            }

            $this.on('change', function (i) {
                i = $this.children('option:selected').index() - 1
                var r = $this.val()
                if (r != '') {
                    shipping_district(i);
                } else {
                    $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>')
                }
            })
        })

        if(procvinces != null && procvinces.length > 1) {
            var t = document.getElementById('provin').value - 1;
            shipping_district(t)
        }
    })

    function shipping_district(i) {
        $('select[name="calc_shipping_district"]').each(function () {
            var str = '', $this = $(this)
            arr[i].forEach(function (el) {
                str += '<option value="' + el + '">' + el + '</option>'
                $this.html('<option value="">Quận / Huyện</option>' + str)
            })
        })
    }

    if(districts != null && districts.length>1){
        $('select[name="calc_shipping_district"] option').each(function () {
            if ($(this).text() == districts) {
                $(this).attr('selected', '')
            }
        })
    }


    $('select[name="calc_shipping_district"]').on('change', function () {
        var target = $(this).children('option:selected')
        target.attr('selected', '')
        $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
        document.getElementById('address_2').value = target.text();
    })

    $('select[name="calc_shipping_provinces"]').on('change', function () {
        var target = $(this).children('option:selected')
        target.attr('selected', '')
        $('select[name="calc_shipping_provinces"] option').not(target).removeAttr('selected')
        document.getElementById('address_1').value = target.text();
    })

}