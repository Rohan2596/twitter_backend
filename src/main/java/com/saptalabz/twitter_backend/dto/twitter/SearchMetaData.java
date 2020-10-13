package com.saptalabz.twitter_backend.dto.twitter;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SearchMetaData {

    public double completed_in;
    public long max_id;
    public String max_id_str;
    public String next_results;
    public String query;
    public String refresh_url;
    public int   count;
    public int since_id;
    public String since_id_str;
}
