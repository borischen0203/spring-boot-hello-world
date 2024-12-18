package springboothelloworld.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class aaa {
    public JSONObject reviewCreateOrUpdate(ResponseObject responseObject, UserInfo userInfo, JSONObject params) throws Exception {
        JSONObject rsJso = new JSONObject();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String lastUpdate = sdf.format(new Date());
            if (params.getString("applyType").equals("create")) {
                int agreementId = params.getInt("agreementId");
                String userId = params.getString("userId");
                Integer userIdInt = userId.isEmpty() ? null : Integer.parseInt(userId);

                if( userIdInt == null || CollectionUtils.isEmpty(agreementReviewRepository.findByAgreementWithUser(agreementId, userIdInt))) {
                    objectMapper.setDateFormat(sdf); // 設置日期格式
                    AgreementReview agreementReviewDetail = objectMapper.convertValue(params.toMap(), AgreementReview.class);
                    agreementReviewDetail.setAgreementId(agreementId);
                    agreementReviewDetail.setUserId(userIdInt);
                    agreementReviewDetail.setLastUpdateUser(userInfo.getUserName());
                    agreementReviewDetail.setLastUpdate(new Date());
                    agreementReviewDetail.setProcessStep(AgreementEnum.REVIEW_COMPLETED.getCode());

                    saveAgreementProcessLog(agreementReviewDetail, null);
//                    agreementReviewRepository.save(agreementReviewDetail);
                } else {
                    logger.info("Agreement ID {} already exists for User ID {}", agreementId, userId);
                }
            } else if (params.getString("applyType").equals("approve")){
                Optional<AgreementReview> reviewOptional = agreementReviewRepository.findById(params.getInt("reviewId"));

                if(!reviewOptional.isPresent()){
                    responseObject.putRo(Code.PARAMETER_INVALID, "agreement_review not found");
                    return rsJso;
                }
                AgreementReview newAgreementReviewDetail = reviewOptional.get();
                AgreementReview oldAgreementReviewDetail = reviewOptional.get();
//                newAgreementReviewDetail.setAuthorizationDate(DateUtil.formatByString(params.get("authorizationDate").toString(),DateUtil.FORMAT_DATE));
                newAgreementReviewDetail.setAuthorizationDate(sdf.parse(params.get("authorizationDate").toString()));
                newAgreementReviewDetail.setFilePath1(params.optString("filePath1"));
                newAgreementReviewDetail.setFilePath2(params.optString("filePath2"));
                newAgreementReviewDetail.setFilePath3(params.optString("filePath3"));
                newAgreementReviewDetail.setFilePath4(params.optString("filePath4"));
                newAgreementReviewDetail.setFilePath5(params.optString("filePath5"));
                newAgreementReviewDetail.setDescription1(params.optString("description1"));
                newAgreementReviewDetail.setDescription2(params.optString("description2"));
                newAgreementReviewDetail.setDescription3(params.optString("description3"));
                newAgreementReviewDetail.setDescription4(params.optString("description4"));
                newAgreementReviewDetail.setDescription5(params.optString("description5"));
                newAgreementReviewDetail.setLastUpdateUser(userInfo.getUserName());
                newAgreementReviewDetail.setLastUpdate(new Date());
                newAgreementReviewDetail.setProcessStep(AgreementEnum.REVIEW_COMPLETED.getCode());
                saveAgreementProcessLog(newAgreementReviewDetail,oldAgreementReviewDetail);
//                agreementReviewRepository.save(newAgreementReviewDetail);
            } else if (params.getString("applyType").equals("edit")) {
                Optional<AgreementReview> reviewOptional = agreementReviewRepository.findById(params.getInt("reviewId"));
                if(!reviewOptional.isPresent()){
                    responseObject.putRo(Code.PARAMETER_INVALID, "agreement_review not found");
                    return rsJso;
                }
                objectMapper.setDateFormat(sdf); // 設置日期格式
                AgreementReview oldAgreementReviewDetail = reviewOptional.get();
                AgreementReview newAgreementReviewDetail = objectMapper
                        .readValue(objectMapper.writeValueAsString(oldAgreementReviewDetail), AgreementReview.class);
                newAgreementReviewDetail = objectMapper
                        .updateValue(newAgreementReviewDetail, params.toMap());
//                AgreementReview newAgreementReviewDetail = reviewOptional.get();
                newAgreementReviewDetail.setUserName(params.getString("userName"));
                newAgreementReviewDetail.setFilePath1(params.optString("filePath1"));
                newAgreementReviewDetail.setFilePath2(params.optString("filePath2"));
                newAgreementReviewDetail.setFilePath3(params.optString("filePath3"));
                newAgreementReviewDetail.setFilePath4(params.optString("filePath4"));
                newAgreementReviewDetail.setFilePath5(params.optString("filePath5"));
                newAgreementReviewDetail.setDescription1(params.optString("description1"));
                newAgreementReviewDetail.setDescription2(params.optString("description2"));
                newAgreementReviewDetail.setDescription3(params.optString("description3"));
                newAgreementReviewDetail.setDescription4(params.optString("description4"));
                newAgreementReviewDetail.setDescription5(params.optString("description5"));
                newAgreementReviewDetail.setRemarks(params.optString("remarks"));
                newAgreementReviewDetail.setLastUpdateUser(userInfo.getUserName());
                newAgreementReviewDetail.setLastUpdate(new Date());
                newAgreementReviewDetail.setProcessStep(AgreementEnum.REVIEW_COMPLETED.getCode());
                saveAgreementProcessLog(newAgreementReviewDetail,oldAgreementReviewDetail);
//                agreementReviewRepository.save(newAgreementReviewDetail);
            }
        } catch (Exception ex){
            logger.error("update method error:{}", ex.toString());
            responseObject.putRo(Code.INTERNAL_ERROR, ex.toString());
        }
        return rsJso;
    }
}
