package br.com.stant.libraries.uilibrary.components.informationcardview;

/**
 * Created by stant02 on 25/06/18.
 */

public interface InformationCardViewContract {

    void setTitle(String title);
    void setDeadline(String deadline);
    void setActions(String actions);
    void setCreatedAt(String createdAt);
    void setType(String type);
    void setOccurrenceID(String occurrenceID);
    void setSeverityLevel(Integer level);
    void setDarkCardStyle();
    void setDeadlineVisibility(Integer visibility);
    void setArrowVisibility(Integer visibility);
    void setServiceInspectionFormFilledId(Long serviceInspectionFormFilledId);
    void setTextTagExternal(String external);
    void setVisibilityExternal(Integer visibilityExternal);
    void setVisibilityStatusIcon(Integer visibilityStatusIcon);
    void setVisibilityActions(Integer visibilityActions);
    void setVisibilityContainerExternalActions(Integer visibilityContainerExternalActions);
}
