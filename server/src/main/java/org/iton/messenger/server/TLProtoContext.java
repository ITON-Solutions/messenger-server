package org.iton.messenger.server;

import org.iton.messenger.api.*;
import org.iton.messenger.api.auth.TLAuthAuthorization;
import org.iton.messenger.api.auth.TLAuthPasswordRecovery;
import org.iton.messenger.api.help.TLInviteText;
import org.iton.messenger.api.messages.TLAffectedHistory;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.proto.tl.*;
import org.iton.messenger.proto.tl.pq.*;
import org.iton.messenger.server.requests.*;


public class TLProtoContext extends TLContext {
    @Override
    protected void init() {

        registerClass(TLRequestPQ.CLASS_ID, TLRequestPQ.class);
        registerClass(TLResPQ.CLASS_ID, TLResPQ.class);
        registerClass(TLPQInner.CLASS_ID, TLPQInner.class);
        registerClass(TLRequestDhParams.CLASS_ID, TLRequestDhParams.class);
        registerClass(TLServerDhParamsOk.CLASS_ID, TLServerDhParamsOk.class);
        registerClass(TLServerDhParamsFailure.CLASS_ID, TLServerDhParamsFailure.class);
        registerClass(TLServerDhInner.CLASS_ID, TLServerDhInner.class);
        registerClass(TLClientDhResultOk.CLASS_ID, TLClientDhResultOk.class);
        registerClass(TLClientDhResultFailure.CLASS_ID, TLClientDhResultFailure.class);
        registerClass(TLClientDhResultRetry.CLASS_ID, TLClientDhResultRetry.class);
        registerClass(TLClientDhParams.CLASS_ID, TLClientDhParams.class);
        registerClass(TLClientDhInner.CLASS_ID, TLClientDhInner.class);

        registerClass(TLPing.CLASS_ID, TLPing.class);
        registerClass(TLPingDelayDisconnect.CLASS_ID, TLPingDelayDisconnect.class);
        registerClass(TLPong.CLASS_ID, TLPong.class);
        registerClass(TLMessagesAck.CLASS_ID, TLMessagesAck.class);
        registerClass(MTNewSessionCreated.CLASS_ID, MTNewSessionCreated.class);
        registerClass(MTBadMessageNotification.CLASS_ID, MTBadMessageNotification.class);
        registerClass(MTBadServerSalt.CLASS_ID, MTBadServerSalt.class);
        registerClass(MTNewMessageDetailedInfo.CLASS_ID, MTNewMessageDetailedInfo.class);
        registerClass(MTMessageDetailedInfo.CLASS_ID, MTMessageDetailedInfo.class);
        registerClass(MTNeedResendMessage.CLASS_ID, MTNeedResendMessage.class);
        registerClass(TLMessagesContainer.CLASS_ID, TLMessagesContainer.class);
        registerClass(MTInvokeAfter.CLASS_ID, MTInvokeAfter.class);
        registerClass(TLRPCError.CLASS_ID, TLRPCError.class);
        registerClass(TLRPCResult.CLASS_ID, TLRPCResult.class);
        registerClass(TLGetFutureSalts.CLASS_ID, TLGetFutureSalts.class);
        registerClass(TLFutureSalt.CLASS_ID, TLFutureSalt.class);
        registerClass(TLFutureSalts.CLASS_ID, TLFutureSalts.class);
        registerClass(TLInputUserContact.CLASS_ID, TLInputUserContact.class);
        registerClass(TLInputPeerContact.CLASS_ID, TLInputPeerContact.class);
        registerClass(TLInviteText.CLASS_ID, TLInviteText.class);
        registerClass(TLAffectedHistory.CLASS_ID, TLAffectedHistory.class);
        registerClass(TLInputMessagesFilterPhotoVideo.CLASS_ID, TLInputMessagesFilterPhotoVideo.class);
        registerClass(TLInputMessagesFilterAudio.CLASS_ID, TLInputMessagesFilterAudio.class);
        registerClass(TLInputMessagesFilterDocument.CLASS_ID, TLInputMessagesFilterDocument.class);
        registerClass(TLInputMessagesFilterEmpty.CLASS_ID, TLInputMessagesFilterEmpty.class);
        registerClass(TLInputMessagesFilterPhotos.CLASS_ID, TLInputMessagesFilterPhotos.class);
        registerClass(TLInputMessagesFilterVideo.CLASS_ID, TLInputMessagesFilterVideo.class);
        registerClass(TLInputPhoneContact.CLASS_ID, TLInputPhoneContact.class);
        registerClass(TLInputMediaGeoPoint.CLASS_ID, TLInputMediaGeoPoint.class);
        registerClass(TLInputGeoPoint.CLASS_ID, TLInputGeoPoint.class);
        registerClass(TLInputFileLocation.CLASS_ID, TLInputFileLocation.class);
        registerClass(TLInputPrivacyKeyStatusTimestamp.CLASS_ID, TLInputPrivacyKeyStatusTimestamp.class);
        registerClass(TLAccountPasswordInputSettings.CLASS_ID, TLAccountPasswordInputSettings.class);
        registerClass(TLAccountTTL.CLASS_ID, TLAccountTTL.class);
        registerClass(TLAuthPasswordRecovery.CLASS_ID, TLAuthPasswordRecovery.class);
        registerClass(TLInputFile.CLASS_ID, TLInputFile.class);
        registerClass(TLInputGeoPointEmpty.CLASS_ID, TLInputGeoPointEmpty.class);
        registerClass(TLInputPhotoCropAuto.CLASS_ID, TLInputPhotoCropAuto.class);
        registerClass(TLAuthAuthorization.CLASS_ID, TLAuthAuthorization.class);
        registerClass(TLInputUserSelf.CLASS_ID, TLInputUserSelf.class);
        registerClass(TLUserSelf.CLASS_ID, TLUserSelf.class);
        registerClass(TLUserEmpty.CLASS_ID, TLUserEmpty.class);
        registerClass(TLUserProfilePhoto.CLASS_ID, TLUserProfilePhoto.class);
        registerClass(TLFileLocation.CLASS_ID, TLFileLocation.class);
        registerClass(TLUserStatusOnline.CLASS_ID, TLUserStatusOnline.class);
        registerClass(TLInputUserForeign.CLASS_ID, TLInputUserForeign.class);
        registerClass(TLInputPeerForeign.CLASS_ID, TLInputPeerForeign.class);
        registerClass(TLInputPhotoEmpty.CLASS_ID, TLInputPhotoEmpty.class);
        registerClass(TLInputMediaUploadedDocument.CLASS_ID, TLInputMediaUploadedDocument.class);
        registerClass(TLInputMediaContact.CLASS_ID, TLInputMediaContact.class);
        registerClass(TLInputMediaUploadedPhoto.CLASS_ID, TLInputMediaUploadedPhoto.class);
        registerClass(TLDocumentAttributeFilename.CLASS_ID, TLDocumentAttributeFilename.class);
        registerClass(TLUserProfilePhotoEmpty.CLASS_ID, TLUserProfilePhotoEmpty.class);
        registerClass(TLSendMessageTypingAction.CLASS_ID, TLSendMessageTypingAction.class);

        registerClass(TLRequestInvokeWithLayer.CLASS_ID, TLRequestInvokeWithLayer.class);
        registerClass(TLRequestInitConnection.CLASS_ID, TLRequestInitConnection.class);
        registerClass(TLRequestAccountRegisterDevice.CLASS_ID, TLRequestAccountRegisterDevice.class);
        registerClass(TLRequestHelpGetConfig.CLASS_ID, TLRequestHelpGetConfig.class);
        registerClass(TLRequestDestroySession.CLASS_ID, TLRequestDestroySession.class);
        registerClass(TLRequestAuthSendCode.CLASS_ID, TLRequestAuthSendCode.class);
        registerClass(TLRequestAuthSendCall.CLASS_ID, TLRequestAuthSendCall.class);
        registerClass(TLRequestAuthSignIn.CLASS_ID, TLRequestAuthSignIn.class);
        registerClass(TLRequestAuthSignUp.CLASS_ID, TLRequestAuthSignUp.class);
        registerClass(TLRequestHelpGetInviteText.CLASS_ID, TLRequestHelpGetInviteText.class);
        registerClass(TLRequestAccountUpdateStatus.CLASS_ID, TLRequestAccountUpdateStatus.class);
        registerClass(TLRequestUpdatesGetState.CLASS_ID, TLRequestUpdatesGetState.class);
        registerClass(TLRequestContactsGetBlocked.CLASS_ID, TLRequestContactsGetBlocked.class);
        registerClass(TLRequestContactsGetContacts.CLASS_ID, TLRequestContactsGetContacts.class);
        registerClass(TLRequestMessagesGetDialogs.CLASS_ID, TLRequestMessagesGetDialogs.class);
        registerClass(TLRequestContactsGetStatuses.CLASS_ID, TLRequestContactsGetStatuses.class);
        registerClass(TLRequestUsersGetFullUser.CLASS_ID, TLRequestUsersGetFullUser.class);
        registerClass(TLRequestAccountUpdateProfile.CLASS_ID, TLRequestAccountUpdateProfile.class);
        registerClass(TLRequestAuthLogOut.CLASS_ID, TLRequestAuthLogOut.class);
        registerClass(TLRequestHelpGetSupport.CLASS_ID, TLRequestHelpGetSupport.class);
        registerClass(TLRequestMessagesGetHistory.CLASS_ID, TLRequestMessagesGetHistory.class);
        registerClass(TLRequestMessagesDeleteHistory.CLASS_ID, TLRequestMessagesDeleteHistory.class);
        registerClass(TLRequestMessagesDeleteMessages.CLASS_ID, TLRequestMessagesDeleteMessages.class);
        registerClass(TLRequestMessagesGetAllStickers.CLASS_ID, TLRequestMessagesGetAllStickers.class);
        registerClass(TLRequestAccountUpdateUsername.CLASS_ID, TLRequestAccountUpdateUsername.class);
        registerClass(TLRequestAccountCheckUsername.CLASS_ID, TLRequestAccountCheckUsername.class);
        registerClass(TLRequestAccountGetWallPapers.CLASS_ID, TLRequestAccountGetWallPapers.class);
        registerClass(TLRequestAccountGetTTL.CLASS_ID, TLRequestAccountGetTTL.class);
        registerClass(TLRequestAccountGetPrivacy.CLASS_ID, TLRequestAccountGetPrivacy.class);
        registerClass(TLRequestMessagesReadHistory.CLASS_ID, TLRequestMessagesReadHistory.class);
        registerClass(TLRequestMessagesSendMessage.CLASS_ID, TLRequestMessagesSendMessage.class);
        registerClass(TLRequestMessagesSearch.CLASS_ID, TLRequestMessagesSearch.class);
        registerClass(TLRequestContactsImportContacts.CLASS_ID, TLRequestContactsImportContacts.class);
        registerClass(TLRequestRpcDropAnswer.CLASS_ID, TLRequestRpcDropAnswer.class);
        registerClass(TLRequestMessagesSendMedia.CLASS_ID, TLRequestMessagesSendMedia.class);
        registerClass(TLRequestUploadGetFile.CLASS_ID, TLRequestUploadGetFile.class);
        registerClass(TLRequestAccountGetAuthorizations.CLASS_ID, TLRequestAccountGetAuthorizations.class);
        registerClass(TLRequestAccountResetAuthorization.CLASS_ID, TLRequestAccountResetAuthorization.class);
        registerClass(TLRequestAccountGetPassword.CLASS_ID, TLRequestAccountGetPassword.class);
        registerClass(TLRequestAccountGetPasswordSettings.CLASS_ID, TLRequestAccountGetPasswordSettings.class);
        registerClass(TLRequestAccountUpdatePasswordSettings.CLASS_ID, TLRequestAccountUpdatePasswordSettings.class);
        registerClass(TLRequestAccountSetAccountTTL.CLASS_ID, TLRequestAccountSetAccountTTL.class);
        registerClass(TLRequestAuthRequestPasswordRecovery.CLASS_ID, TLRequestAuthRequestPasswordRecovery.class);
        registerClass(TLRequestAuthRecoverPassword.CLASS_ID, TLRequestAuthRecoverPassword.class);
        registerClass(TLRequestUploadSaveFilePart.CLASS_ID, TLRequestUploadSaveFilePart.class);
        registerClass(TLRequestPhotosUploadProfilePhoto.CLASS_ID, TLRequestPhotosUploadProfilePhoto.class);
        registerClass(TLRequestPhotosGetUserPhotos.CLASS_ID, TLRequestPhotosGetUserPhotos.class);
        registerClass(TLRequestAccountSendChangePhoneCode.CLASS_ID, TLRequestAccountSendChangePhoneCode.class);
        registerClass(TLRequestAccountChangePhone.CLASS_ID, TLRequestAccountChangePhone.class);
        registerClass(TLRequestMessagesSetTyping.CLASS_ID, TLRequestMessagesSetTyping.class);
        registerClass(TLRequestPhotosUpdateProfilePhoto.CLASS_ID, TLRequestPhotosUpdateProfilePhoto.class);
        registerClass(TLRequestContactsSearch.CLASS_ID, TLRequestContactsSearch.class);
        registerClass(TLRequestMessagesCreateChat.CLASS_ID, TLRequestMessagesCreateChat.class);
        registerClass(TLRequestMessagesGetFullChat.CLASS_ID, TLRequestMessagesGetFullChat.class);
        registerClass(TLRequestUpdatesGetDifference.CLASS_ID, TLRequestUpdatesGetDifference.class);
    }
}
