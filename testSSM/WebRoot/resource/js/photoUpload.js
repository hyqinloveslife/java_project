Ext.onReady(function(){
    Ext.create('Ext.form.Panel', {
        title: 'ͼƬ�ϴ�',
        width: 600,
        bodyPadding: 10,
        frame: true,
        renderTo: Ext.getBody(),
        items: [{
            xtype: 'filefield',
            name: 'file',
            fieldLabel: 'Photo',
            labelWidth: 50,
            msgTarget: 'side',
            fileUpload: true ,
            allowBlank: false,
            blankText:"Select an image",
            emptyText: 'You can only upload a single PNG 10M or less, JPG, GIF format images',
            anchor: '100%',
            buttonText: 'ѡ��ͼƬ'
        }],

        buttons: [{
            text: '�ϴ�',
            handler: function() {
                var form = this.up('form').getForm();
                if(form.isValid()){
                    form.submit({
                        url: '/shop/auth/photoUpload',
                        waitMsg: '�����ϴ�ͼƬ...',
                        success: function(fp, o) {
                            Ext.Msg.alert('��ʾ', o.result.msg);
                        }
                    });
                }
            }
        }]
    });
});