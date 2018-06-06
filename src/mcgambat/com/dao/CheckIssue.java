
package mcgambat.com.dao;

import java.sql.ResultSet;
import mcgambat.com.models.CheckIssueModel;


public interface CheckIssue {

    public ResultSet getAllCheckIssues();
    public int insertCheckIssueRecord(CheckIssueModel checkIssueModel);  
    public int updateCheckIssueRecord(CheckIssueModel checkIssueModel);
    public int deleteCheckIssueRecord(Integer id);
}
