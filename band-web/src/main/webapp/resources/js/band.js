/**
 * Created by Mindfield on 2016. 09. 23..
 */

function hideDialogOnSuccess(xhr, status,args) {
    if(args.validationFailed) {
        PF('band-mate-add-dialog').jq.effect("shake", {times:5}, 100);
    }
    else {
        PF('band-mate-add-dialog').hide();
    }
}