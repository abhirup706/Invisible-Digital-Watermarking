function tif2avi

clc; close all;
[imagelist,p]=uigetfile('*.png','MultiSelect','on',...
     'Select LIST to plot'); pause(0.5); cd(p);
 if ~iscell(imagelist); disp('imagelist not cell'); return; end;

outputVideo = VideoWriter('tgt.avi');
outputVideo.FrameRate = 10;
outputVideo.Quality = 100;
open(outputVideo);

for i=1:numel(imagelist)
    img=imread(imagelist{i});
    writeVideo(outputVideo,img);
end