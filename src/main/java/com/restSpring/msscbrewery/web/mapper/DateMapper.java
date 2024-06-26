package com.restSpring.msscbrewery.web.mapper;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DateMapper {
	public OffsetDateTime asOffSetDateTime(Timestamp ts){
		if(ts != null) {
			return OffsetDateTime.of(ts.toLocalDateTime().getYear(), ts.toLocalDateTime().getMonthValue(), 
					ts.toLocalDateTime().getDayOfMonth(), ts.toLocalDateTime().getHour(), ts.toLocalDateTime().getMinute(),
					ts.toLocalDateTime().getSecond(), ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
		}
		else{
			return null;
		}
	}
	
	public Timestamp asTimestamp(OffsetDateTime ts){
		if(ts != null) {
			return Timestamp.valueOf(ts.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
		}
		else {
			return null;
		}	
	}
}
