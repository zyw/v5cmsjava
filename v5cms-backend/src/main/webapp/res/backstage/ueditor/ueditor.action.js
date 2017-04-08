/**
 * Created by ZYW on 2014/11/24.
 */
;(function(){
    var contextPaht = $("#v5cms_context_path").val();

    window.UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    window.UE.Editor.prototype.getActionUrl = function(action) {
        if (action == 'uploadimage' || action == 'uploadscrawl' || action == 'uploadfile' || action == 'uploadvideo') {
            return contextPaht + '/manager/ueditor/upload?action='+action;
        } else {
            return this._bkGetActionUrl.call(this, action);
        }
    };
}());