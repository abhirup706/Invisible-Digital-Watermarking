vid=mmreader('Src.avi');
 numFrames = vid.NumberOfFrames;
 n=numFrames;
 for i = 1:10:n
 frames = read(vid,i);
 imwrite(frames,['frames/Image' int2str(i), '.jpg']);
 im(i)=image(frames);
 end
